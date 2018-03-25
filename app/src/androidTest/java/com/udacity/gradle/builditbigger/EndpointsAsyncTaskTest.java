package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.support.v4.util.Pair;
import android.test.AndroidTestCase;

import org.junit.Test;

/**
 * Created by jemanuels on 2018/03/21.
 */
public class EndpointsAsyncTaskTest extends AndroidTestCase{

    Context context;

    @Test
    public void test() throws Exception {
        context = getContext();
        EndpointsAsyncTask endpointsAsyncTask = new EndpointsAsyncTask(context, null);

        assertNotNull(endpointsAsyncTask.execute().get());
    }

}