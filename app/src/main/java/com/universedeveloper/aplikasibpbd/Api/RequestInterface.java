package com.universedeveloper.aplikasibpbd.Api;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RequestInterface {
    @GET("list_berita.php")
    Call<JSONResponse> getBerita(@Query("id_language") String id_language,
                                 @Query("id_category") String id_category,
                                 @Query("active") String active);
}
