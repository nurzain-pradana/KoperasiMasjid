package com.nurzainpradana.koperasimasjid.api;

import com.nurzainpradana.koperasimasjid.api.response.JsonRespon;
import com.nurzainpradana.koperasimasjid.model.AddtoCart;
import com.nurzainpradana.koperasimasjid.model.CartDetail;
import com.nurzainpradana.koperasimasjid.model.FavoriteDetail;
import com.nurzainpradana.koperasimasjid.model.Result;
import com.nurzainpradana.koperasimasjid.model.ResultUser;
import com.nurzainpradana.koperasimasjid.model.User;

import java.util.Date;
import java.util.List;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface ApiInterface {

    @FormUrlEncoded
    @POST("api/user/getUser.php")
    Call<List<User>> getUser(@Field("username") String username);

    @FormUrlEncoded
    @POST("api/user/checkUsername.php")
    Call<List<User>> checkUsername(@Field("username") String username);

    @FormUrlEncoded
    @POST("api/user/uploadPhotoProfile.php")
    Call<Result> uploadPhotoProfile(@Field("image") String image,
                                        @Field("filename") String filename);

    @FormUrlEncoded
    @POST("api/user/removePhotoProfile.php")
    Call<Result> removePhotoProfile(@Field("filename") String filename);

    @GET("api/user/getAllUser.php")
    Call<ResultUser> getAllUser();

    @FormUrlEncoded
    @POST("api/user/createUser.php")
    Call<ResultUser> insertUser(@Field("name") String name,
                                @Field("no_phone") String no_phone,
                                @Field("username") String username,
                                @Field("password") String password,
                                @Field("email") String email,
                                @Field("address") String address,
                                @Field("date_of_birth") String date_of_birth,
                                @Field("photo_profile") String photo_profile);

    @FormUrlEncoded
    @POST("api/user/updateUser.php")
    Call<Result> updateUser(@Field("id_user") int id_user,
                            @Field("name") String name,
                            @Field("no_phone") String no_phone,
                            @Field("username") String username,
                            @Field("email") String email,
                            @Field("address") String address,
                            @Field("date_of_birth") Date date_of_birth,
                            @Field("photo_profile") String photo_profile);

    @FormUrlEncoded
    @POST("api/user/updatePassword.php")
    Call<Result> updatePassword(
                            @Field("username") String username,
                            @Field("password") String password);

    @FormUrlEncoded
    @POST("api/user/deleteUser.php")
    Call<ResultUser> deleteUser(@Field("id_user") int id_user);

    //
    @GET("/koperasimasjid/api/product/new_product.php")
    Call<JsonRespon> getNew();

    @GET("/koperasimasjid/api/product/best_product.php")
    Call<JsonRespon> getBest();

    @GET("/koperasimasjid/api/product/womens_product.php")
    Call<JsonRespon> getWomens();

    @GET("/koperasimasjid/api/product/stationery_product.php")
    Call<JsonRespon> getStationery();

    //Add to Cart
    @Multipart
    @POST("/koperasimasjid/api/cart/add_to_cart.php")
    Call<Result> addtocartcall(
            //@Part("securecode") String securecode,
            @Part("id_products") int id_products,
            @Part("id_user") int id_user,
            @Part("quantity") int quantity
    );

    //Add to wishlist
    /*@Multipart
    @POST("android/add_to_wishlist.php")
    Call<AddtoCart> addtoWishlist(
            @Part("securecode") RequestBody securecode,
            @Part("id_products") RequestBody id_products,
            @Part("id_member") RequestBody id_member,
            @Part("price") RequestBody price
    );

     */



    //Add to Favorite
    @Multipart
    @POST("/koperasimasjid/api/favorite/add_to_favorite.php")
    Call<Result> addtoFavorite(
            @Part("id_products") Integer id_products,
            @Part("id_user")Integer id_user);


    @FormUrlEncoded
    @POST("/koperasimasjid/api/favorite/check_favorite.php")
    Call<Result> checkFavorite(
            @Field("id_user") Integer id_user,
            @Field("id_products") Integer id_products);

    @Multipart
    @POST("/koperasimasjid/api/favorite/delete_from_favorite.php")
    Call<Result> deleteFromFavorite(
            @Part("id_products") Integer id_products,
            @Part("id_user") Integer id_user);

    @Multipart
    @POST("/koperasimasjid/api/favorite/favorite_product.php")
    Call<JsonRespon> getFavorite(@Part("id_user") Integer id_user);

<<<<<<< HEAD

=======
>>>>>>> 28928c4778c94d5b35fe76750c34828edb8ced5b
    //get user cart
    @Multipart
    @POST("android/getusercartdetail.php")
    Call<CartDetail> getCartDetail(
            @Part("securecode") RequestBody securecode,
            @Part("qoute_id") RequestBody qoute_id,
            @Part("id_member") RequestBody id_member
    );

    //get user wishlist
    @Multipart
    @POST("android/getuserwishlist.php")
    Call<FavoriteDetail> getCartDetail(
            @Part("securecode") RequestBody securecode,
            @Part("id_member") RequestBody id_member
    );
}
