package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v4.util.Pair;
import android.view.View;
import android.widget.ProgressBar;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;
import com.udacity.gradle.builditbigger.backend.myApi.model.MyBean;

import java.io.IOException;

import za.co.samtakie.myjokeui.JokeUIActivity;

/**
 * Created by jemanuels on 2018/03/22.
 * This Asynctask will get the data from the local server and feed it back to the android app
 */

class EndpointsAsyncTask extends AsyncTask<Pair<Context, String>, Void, String> {
    private static MyApi myApiService = null;
    private Context context;
    private ProgressBar progressBar;

    public EndpointsAsyncTask(Context context, ProgressBar progressBar) {
        this.context = context;
        this.progressBar = progressBar;
    }

    @Override
    protected String doInBackground(Pair<Context, String>... params) {
        if (myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    // options for running against local devappserver
                    // - 10.0.2.2 is localhost's IP address in Android emulator
                    // - turn off compression when running against local devappserver
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            // end options for devappserver
            myApiService = builder.build();
        }

        try {
            return myApiService.djogaJoke(new MyBean()).execute().getMyJokes();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    /**
     * Override this method to load the progressbar while the do in background and is getting the
     * data, progressbar will be hidden in the onPostExecute method
     */
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        if(progressBar != null){
            progressBar.setVisibility(View.VISIBLE);
        }
    }

    @Override
    protected void onPostExecute(String result) {
        if(progressBar!= null){
            progressBar.setVisibility(View.GONE);
        }

        // Create a new intent and send the result via the joke name to the JokeUIActivity class
        Intent intent = new Intent(context, JokeUIActivity.class);
        intent.putExtra("joke", result);
        context.startActivity(intent);
    }
}
