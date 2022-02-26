# fruits-n-season
Android application that displays fruits currently in season depending on the month.
```diff
@@ Utilizes Firebase Realtime DB @@
```

### Mockup/Framework:
This is a quick draft for project. Initially I wanted to create a search function 
but given the timeframe I would not have been able to add that function as I had to fulfill other requirements.


![image](https://user-images.githubusercontent.com/64164615/155824995-84ad83d2-1244-4ec5-8140-29df7014fef2.png)
>In this draft, you can see many similarities between it and the current product but in the end I chose to use a different color for the fonts. In addition,
>changing the colors for the bottomNavBar was getting too complicated so I had to opt for what I had in themes and had to make do.

### Project Screenshots:

#### Home Screen (Fragment)
![image](https://user-images.githubusercontent.com/64164615/155825163-e7289b87-8e2b-41db-81a9-6dea133d3820.png)
> Homepage displays the current month and fruits that are in season.

#### DetailFragment1
![image](https://user-images.githubusercontent.com/64164615/155825317-ab85cfb3-06d9-4791-97fd-53903c648bce.png)
> Displays a bigger picture of the fruit clicked and also the months the fruit is considered `in season.`


#### Month Screen (Fragment) && ListFragment
![image](https://user-images.githubusercontent.com/64164615/155825354-238df90f-0a58-4c31-a073-5f5f2f42e8f9.png)
![image](https://user-images.githubusercontent.com/64164615/155825367-10e52053-15ff-4c02-b0ac-ea0df0c4650b.png)
> The Month screen contains buttons that basically sends in a bundled argument to the ListFragment of which it will display the current fruit in season for that clicked month button.

#### DetailFragment2
![image](https://user-images.githubusercontent.com/64164615/155825428-f7a94c7f-df22-4a54-93c9-17ae79350f4c.png)
> This fragment is very similar to the first DetailFragment, the only difference is that this one essentially takes in a bundle of arguments containing
> the ID (or in my case, the order of the fruit that was clicked based on the month) and the month String which is necessary to loop for the correct order of the fruit.

#### Resource Screen (Fragment)
![image](https://user-images.githubusercontent.com/64164615/155825441-f5b51faf-9868-4b82-9e79-4a59816923f1.png)

#### Settings Activity (Plain & Simple Theme Changing)
![image](https://user-images.githubusercontent.com/64164615/155825550-96a18d66-c4ba-4d5e-a886-bebbf7542eac.png)
![image](https://user-images.githubusercontent.com/64164615/155825558-2f1ada80-a940-4309-b054-20094b470a44.png)


![image](https://user-images.githubusercontent.com/64164615/155825562-67002fb4-200b-4087-b389-730cec95c1c2.png)
![image](https://user-images.githubusercontent.com/64164615/155825163-e7289b87-8e2b-41db-81a9-6dea133d3820.png)

![image](https://user-images.githubusercontent.com/64164615/155825574-491822f1-d26a-48b6-b0a6-1e7e7a267b78.png)
![image](https://user-images.githubusercontent.com/64164615/155825611-9d18c53f-7b71-4e06-80d0-5b85a3f60f8a.png)

![image](https://user-images.githubusercontent.com/64164615/155825585-321658b5-ae0a-4b32-934b-51b196eb6b3e.png)
![image](https://user-images.githubusercontent.com/64164615/155825354-238df90f-0a58-4c31-a073-5f5f2f42e8f9.png)

![image](https://user-images.githubusercontent.com/64164615/155825582-6874fc22-2068-41df-b23b-7bd9d3f8dc74.png)
![image](https://user-images.githubusercontent.com/64164615/155825441-f5b51faf-9868-4b82-9e79-4a59816923f1.png)




