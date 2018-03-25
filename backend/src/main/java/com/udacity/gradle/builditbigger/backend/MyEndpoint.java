package com.udacity.gradle.builditbigger.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

/** An endpoint class we are exposing */
@Api(
        name = "myApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.builditbigger.gradle.udacity.com",
                ownerName = "backend.builditbigger.gradle.udacity.com",
                packagePath = ""
        )
)
public class MyEndpoint {
    /** this endpoint get's his data from the java library named myJokes via MyBean
     * the name is djogaJoke, this will be shown when the local server has been started*/
    @ApiMethod(name = "djogaJoke")
    public MyBean djogaJoke(MyBean djogajoke) {
        return djogajoke;
    }

}