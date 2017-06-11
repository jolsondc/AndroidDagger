package com.jolly.androiddagger.Network;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Jollyboy on 10/06/17.
 */

public interface Http {

    @GET("posts")
    Call<ResponseBody> makeCall();


}
