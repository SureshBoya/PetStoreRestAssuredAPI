package api.endpoints;
/*
Swagger URI --> https://petstore.swagger.io
Create user(Post) : https://petstore.swagger.io/v2/user
Get user (Get): https://petstore.swagger.io/v2/user/{username}
Update user (Put) : https://petstore.swagger.io/v2/user/{username}
Delete user (Delete) : https://petstore.swagger.io/v2/user/{username}

Store
	 * post place an order -->https://petstore.swagger.io/v2/store/order
	 * get find purchase order by ID --> https://petstore.swagger.io/v2/store/order/{id}
	 * delete purchase order by ID --> https://petstore.swagger.io/v2/store/order/{id}
	 * get return pet inventories by status -->https://petstore.swagger.io/v2/store/inventory
	 
 */
public class Routes {
	
	public static String base_url="https://petstore.swagger.io/v2";
	
	//user module urls
	public static String post_url=base_url+"/user";
	public static String get_url=base_url+"/user/{username}";
	public static String put_url=base_url+"/user/{username}";
	public static String delete_url=base_url+"/user/{username}";
	public static String post_url_withGivenInputArray=base_url+"/user/createWithArray";
	
	//store module url
	public static String store_Post_url=base_url+"/store/order";
	public static String store_get_url=base_url+"/store/order/{id}";
	public static String store_delete_url=base_url+"/store/order/{id}";
	public static String store_getByStaus_url=base_url+"/store/inventory";
	
	//pet module
	public static String pet_post_url=base_url+"/pet";
	public static String pet_get_url=base_url+"/pet/{id}";
	public static String pet_put_url=base_url+"/pet/{id}";
	public static String pet_delete_url=base_url+"/pet/{id}";
	public static String pet_get_Status_url=base_url+"/pet/findByStatus?status={status}";
	
	
}
