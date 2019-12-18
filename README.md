# ShopifyWinter2018Challenge

Shopify's Winter 2018 Mobile Intern Challenge:

Problem:
You're a successful Shopify merchant! Your orders have grown to a point that you can’t keep track of them on your fingers anymore. Create a mobile app that displays an Order Summary Page. Your summary will show the following 2 categories:

Orders by Province: Number of orders from each province

Each province will be its own subheading. So, “Orders by Province” will be the heading and “x number of orders from Alaska”, for example, will be the subheading. The number of subheadings depends on how many different provinces the orders were shipped to.

Orders by Year: Number of orders created

You can access the list of orders, and their properties, via the Shopify Orders List REST API (https://shopicruit.myshopify.com/admin/orders.json?page=1&access_token=c32313df0d0ef512ca64d5b336a0d7c6). Reading through the properties’ descriptions will help you determine how to categorize orders in each category. It is possible for a single order to be in more than one category.

Extra 1:

Feeling adventurous? Under the Orders by Year category, display the first 10 orders (their names and any other basic metadata) that belong to that category.

Extra 2:

Wow you are still here. Now let's try opening a new screen when you tap on the Orders by Province category headline. The screen should show the full list of orders belonging to each province. The provinces will be listed in alphabetical order. So, your screen will have the following format:

Alabama

Order 1

Order 2

Alaska

Order 1

Order 2
.... and so on.

Note that the API link is only for the first page of orders (for this challenge you can ignore any additional pages). Here are a couple simple libraries that you can use to fetch the data (these are optional, you can pick one or use any other alternative).
Android:
http://square.github.io/retrofit/
http://square.github.io/okhttp/
iOS:
https://github.com/Alamofire/Alamofire/

What you need to submit:
The order summary page
A simple screenshot of your app showing the summary
If you chose to add any of the extra challenges, include a video of those solutions.
Your project code.
