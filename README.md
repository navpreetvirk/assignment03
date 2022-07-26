Students will be designing an application with object oriented concepts for the following high level requirements. 

Some instructions were provided in the first two questions, but in this question, the students will be using the best approach as per their knowledge to design the application and to build the application. 

We have covered different design approaches in the class, please pick one, and provide justification.

# High Level Requirements:
You can either pick a restaurant or an ecommerce business. 
A user will be provided a menu. The menu will be formatted as follows.

    Collection     =>   ProductType     (T-Shirts)
	Product Name		Product Price
1	Men’s T-Shirt		$15.00 
2	Women’s T-Shirt	    $15.00 

    Collection Two   => ProductType_Two  (Pants)
	Product Name		Product Price
1	Men’s Pant		    $10.00 
2	Women’s Pants	    $25.00 

OR

    Collection       => FoodType(Chicken)
#	Food Item		    Product Price
1	Butter Chicken	    $15.00 
2	Tandoori Chicken 	$15.00 

    Collection Two   => FoodType_Two(Vegan)
#	Product Name		Product Price
1	Vegan Item one	    $10.00 
2	Vegan Item Two	    $25.00 


There are different sources available on the internet for formatting, but the following document can be a good start.
https://docs.oracle.com/javase/10/docs/api/java/io/Console.html#format(java.lang.String,%20java.lang.Object...)
A user can add as many items as they want. Your application keeps asking if the user would like to order anything else or not. Based on the user input, you will perform the further actions.

# Expected Output:

On order completion, you will be providing the total amount with taxes and other information. 
For instance, if you have picked an ecommerce business, you will show the total, and ask the user how they would like to pay. As soon as the user picks a payment option, you will be prompted a message “Thanks for placing an order, your shipping information will be provided shortly through email”. 
Here, you can use a timer and after 10-15 seconds, you will be displaying the receipt with shipping information.
You add any relevant information on a receipt. 
For instance: a receipt number, order number, some shipping information (Tracking number, and a message "your order	will be delivered in 3-4 days")

There are different sources available on the internet for timer, but the following document can be a good start.
https://docs.oracle.com/javase/7/docs/api/java/util/Timer.html

These are some instructions (you can create the same process for the restaurant order), but you can run your business in your own ways. 
Add as many as conditions or provide as much as information, you can think is relevant as per your business.

# Pseudo Code


create groups

create items in groups


create menu

display menu to user


while user picking item

    add item too array


for items in array

    sum total + tax


prompt payment option

send confirmation