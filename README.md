
## [Lucky Number App](https://github.com/LuisChore/android_apps/tree/master/01LuckyNumberApp)

**Description**: In the main screen the user enters their name, after clicking the button another screen opens with a lucky number assigned to the user and the option to share it.

**Android Topics**: 

* Explicit Intent: Sharing data between activities.
* Implicit Intent: Sharing information between applications.


## [Music Player App](https://github.com/LuisChore/android_apps/tree/master/02MusicPlayerApp)

**Description**: App that allows us to play media(Audio) files stored in the application resources directory with the help of  the Android Multimedia Framework. 

**Android Topics**: 

* Vector Assets: To create default icons for our application. 
* Media Player: To control media in Android Studio. 
* Seekbar(Widget): To display the progress of the media playing. 
* Handler(postDelayed): To manage in a Thread the seekbar. 

## [Video Player App](https://github.com/LuisChore/android_apps/tree/master/03VideoPlayerApp)

**Description**: App that allows us to play videos either stored in the application resources directory or videos fetched from the web. 

**Android Topics**: 

* VideoView (Widget): To display video content  from different sources. 
* MediaController (View): To control the media player.

## [French Teacher App](https://github.com/LuisChore/android_apps/tree/master/04FrenchTeacherApp)

**Description**: App to Learn the colors in  French using Audio Files.

**Android Topics**:

* colors.xml: To define colors in our resources directory. 
* raw/: To save raw files (audio).
* Media Player: To control media files in Android Studio. 

## [World Cup App](https://github.com/LuisChore/android_apps/tree/master/05WorldCupApp)

**Description**: App that displays an interactive custom list of the countries that have won the  World Cup using ListView and  ArrayAdapter
	
**Android Topics**: 

* Adapter: Used as a bridge between an AdapterView(ListView) and the underlying data for that view(countries).
* ArrayAdapter: Adapter used when the data source is represented as a list.
* LayoutInflater: Used to instantiate a layout XML(items_list_layout) into its corresponding View object.
* ViewHolder: Class used as a wrapper around a View that contains the layout for an individual item in the list(countries), used to optimize performance avoiding potential expensive findViewById calls.
  

**Steps**:

* Create  in the main_activity.xml an AdapterView (ListView).
* Create  a custom layout for the items (items_list_layout).
* Create  a Model Class to represent each of the items.It will be a template for  the data we will pass (CountryModelClass).
* Create a Custom Adapter that extends ArrayAdapter<CountryModelClass> (CustomAdapter).
  * Data Source
  * ViewHolder Class
  * Implement Override Methods
 
## [Vaccines App](https://github.com/LuisChore/android_apps/tree/master/06VaccinesApp)

**Description**:  App that displays an interactive custom list of Vaccines using RecyclerView
	
**Android Topics**: 

* RecyclerView: AdapterView to  efficiently display large sets of data, better performance than ListView
* RecyclerView.Adapter: Adapter that provides a binding from a data set to views that are displayed in a RecyclerView

  

**Steps**:

* Create  in the main_activity.xml an AdapterView (RecyclerView).
* Create  a custom layout for the items (recyclerview_item).
* Create  a Custom Model Class to represent each of the items. A template for  the data we will pass (VaccineModel).
* Create a Custom Adapter that extends RecyclerView.Adapter<CustomAdapter.ViewHolder> (CustomAdapter).
   * Data source
   * ViewHolder Class
   * Implement Override Methods


## [Top Games App](https://github.com/LuisChore/android_apps/tree/master/07TopGamesApp)

**Description**:  App that displays a list of video games in a CardView application using RecyclerView, each item will be interactive using click events. 
	
**Android Topics**: 

* Cardview: Widget to display data in a rounded layout, it can be used as an item in ListView or inside a RecyclerView

  

**Steps**:

* Create  in the main_activity.xml an AdapterView (RecyclerView).
* Create  a custom layout for the items (card_item, using CardView).
* Create  a Custom Model Class to represent each of the items. A template for  the data we will pass (GameModel).
* Create a Custom Adapter to connect our data source with the AdapterVIew. It extends RecyclerView.Adapter<CustomAdapter.ViewHolder> (CustomAdapter).
   * Data source
   * ViewHolder Class
   * Implement Override Methods
* Add click event (inside the override method ‘onBindViewHolder’ in the CustomAdapter)


## [Learning Management App](https://github.com/LuisChore/android_apps/tree/master/08LearningApp)

**Description**: App that displays data from a local database and  manages (create, update, delete) a list of courses (RecyclerView) for each category (Spinner). App created using the MVVM pattern.
	
**Android Topics**: 
* Room Database: Database, an abstraction layer over SQLite.
* Repository Pattern:  Design pattern that isolates the data layer from the rest of the app. 
* ViewModel: It manages the data for the UI. It exposes state to the UI and encapsulates related business logic.
* LiveData: Observable data holder class, to update UI components when the underlying data changes using the Observer Pattern.
* Data Binding: To bind UI components in layouts to data sources in your app.
* Spinner: View used to select one value from a dropdown menu.
* ItemTouchHelper. Utility to add ‘swipe to dismiss’ or ‘drag & drop’ for the RecyclerView 
* DiffUtil: Class that finds the difference between two lists and provides the updated list as an output, used to notify updates to a RecyclerView Adapter.

**MVVM steps**
* Model
  * Room Database 
    * Entities classes (Category.java,Course.java)
    * DataAccessObjects interfaces (CourseDAO.java, CategoryDAO.java)
    * Database using Singleton Pattern (CourseDatabase.java)
  * Repository (CourseShopRepository.java)
* ViewModel 
  * ViewModelActivity (MainActivityViewModel.java)
  * LiveData
* View
  * Activities (MainActivity,AddEditActivity)
  * Adapters (CourseAdapter)


**Data Binding Steps for Click Events**
1. Create a Button Layout (activity_main.xml)
2. Create the ClickHandlerClass with onClick method (MainActivity.java)
3. Modify the layout xml file to bind the onClick method to the Button layout (activity_main.xml)

 	  	   <layout>
 	  	     <data>
 	  	       <variable>
   *  Bind Button tag ‘onClick’ attribute with the variable method object @{}

4. Connect the ViewDataBinding object with the Click Handler object (MainActivity.java)


**Spinner Steps using data binding**

1. Create a Spinner Layout (content_main.xml)
2. Create a Spinner Item Layout that defines how the selected choice appears in the spinner (spinner_item.xml)
3. Create a custom Model Class to represent each of the items, make it BaseObservable for binding purposes. (Category.java)

    1. extends BaseObservable
    2. Add @Bindable to the getters
    3. Add notifyPropertyChanged(BR.att_name) to the getters

4. Create an ArrayAdapter that receives the data source and provides the spinner choices. (MainActivity.java)
5. Create the ClickHanlderClass with the onItemSelected method  (MainActivity.java)
6. Modify the layout xml file (<layout> <data> <variable>) to bind the adapter attribute to the Spinner tag. (content_main.xml)

 	  	   <layout>
 	  	     <data>
 	  	       <variable>
   *  Bind TextView tag ‘text’ attribute with the variable attribute object @{}
7. Connect the ViewDataBinding object with the Click Handler object (MainActivity.java)



**RecyclerView using Data Binding**

1. Create  in the layout an AdapterView, RecyclerView (content_main.xml).
2. Create  a custom layout for the items (course_list_item.xml).
3. Create  a Custom Model Class to represent each of the items. A template for  the data we will pass and make it BaseObservable for binding purposes (Course.java).
    a. extends BaseObservable
    b. Add @Bindable to the getters
    c. Add notifyPropertyChanged(BR.att_name) to the setters
4. Modify the layout xml file to bind the object variable with the TextView layouts (course_list_item.xml)

 	  	   <layout>
 	  	     <data>
 	  	       <variable>
 	  	   
   *  Bind TextView tag ‘text’ attribute with the variable attribute object @{}
5. Create a Custom Adapter that extends RecyclerView.Adapter<CustomAdapter.ViewHolder>  (CourseAdapter.java).
    * Data source
    * ViewHolder Class
    * Implement Override Methods
    * Add click Event Listener in the ViewHolder constructor 

**Get result from an activity (start an activity and receive a result back)**
* From Main Activity start the Second Activity for a result back using startActivityForResult (MainActivity)
* Return some value from Second Activity using setResult (AddEditActivity)
* Collect data from the Main Activity using onActivityResult (MainActivity) 

**Diff Util used in the adapter**
1. Create a class of DiffUtil.Callback (CourseDiffCallback.java)
2. Update the dataset without using notifyDataSetChanged (CourseAdapter.java)
3. Invoke dispatchUpdatesTo (CourseAdapter.java)


## [Movie Pro App](https://github.com/LuisChore/android_apps/tree/master/09MoviesProApp)

**Description**: App that fetches online data from a Movie DB API (themoviedb.org) and displays the movies using CardView and RecyclerView, when the user clicks on any movie it will display the movie details in a different Activity.
	
**Android Topics**: 

* Retrofit: Library to retrieve and upload data via a REST-based web service
* GSON: A Java serialization/deserialization library to convert Java Objects into JSON and back.
* Parcelable interface: Enables an object to be passed as a parameter from one activity to another.
* Parcelable.Creator interface: It generates instance of your Parcelable class from a Parcel
* jsonschema2pojo:  Generate Plain Old Java Objects from JSON or JSON-Schema.
* SwipeRefreshLayout:  Implement the swipe-to-refresh UI pattern (MainAcivity.java) 
* @BindingAdapter: Binding Adapters are responsible for making the appropriate framework calls to set values. A static binding adapter method with the BindingAdapter annotation lets you customize how a setter for an attribute is called.
* Glide: fast and efficient open source media management and image loading framework
* CoordinatorLayout: Layout that controls the animation and transactions of various child elements with one another


**MVVM steps**

* Model
    * Retrofit, remote data source. 
    * Model classes (Movie.java,Result.java) 
    * Retrofit Interface (MovieDataService.java)
    * Retrofit Instance (RetrofitInstance.java)
    * Repository 
* ViewModel 
    * ViewModelActivity (ViewModelActivity.java)
    * LiveData
* View
    * Activities (MainActivity.java,MovieActivity.java) 

**Parcel Steps**

1. Create the object that Implements Parcelable (Movie.java,Result.java)
2. Create Overridden Methods
    * writeToParcel
    * describeContents
3. Create a Constructor with a Parcel object to read the data from. 
4. CREATOR field that implements Parcelable.Creator interface

	

**Retrofit Steps**

* Model Class for the data service response (Result.java)
* Retrofit Interface, it defines the possible HTTP methods (MovieDataService.java)
* Retrofit Instance using SIngleton Pattern and GSON converter (RetrofitInstance.java).
* For each required HTTP request create a method in the repository (MovieRepository.java) 
    * Get the Retrofit instance 
    * Call the HTTP request
    * Enqueue Callbacks 
    * Return a LiveData (MutableLiveData) with the data


**Bind a remote image**

1. Inside the BaseObservable Model Class create a static binding adapter method @BindingAdapter (Movie.java)
2. Create an ImageView layout with an attribute that matches the static binding adapter method
3. Load the image with the Glide library


**Coordinator Layout using Scroll-Based Behavior**

( https://blog.mindorks.com/using-coordinator-layout-in-android)

- Add the CoordinatorLayout dependency and the material design components dependency
- Implement the Scroll-Based Behavior using:

 	  	   <CoordinatorLayout>
 	  	        <AppBarLayout>
 	  	            <CollapsingToolbarLayout>
 	  	                <ImageView>
 	  	                <Toolbar>
 	  	                
 	  	                
## [Contacts Manager App](https://github.com/LuisChore/android_apps/tree/master/10ContactsManagerApp)


**Description**: App that displays Contacts (RecyclerView and Cardview)   from a local database, allowing to manage the data, create, delete and update contacts (Room). This application is created using the MVVM architecture and Data Binding library.

	
**Android Topics**: 

* *Room Database*: Object Relational Database library, it provides an abstraction layer over SQLite
    * Entity: Fundamental component that represents a table in the SQLite database
    * Data Access Object: Interface that defines a set of methods for performing database operations on entities.
    * Database: Abstract class that serves as the database holder
* *Repository*: Class that gathers and manages multiple sources of data and provides an API used by ViewModel.
* *ExecutorService*: Executor used to offload operations to background threads.
* *Handler*: It allows you to post tasks to the main UI threads queue. 
* *Runnable*: It defines a task that you want to run asynchronously on a separate thread
* *ItemTouchHelper*: utility class on Android that provides support for handling touch gestures


**MVVM steps**

* Model
    * Room Database (local data source) 
        * Entity (Contacts.java) 
        * Data Access Object (ContactDAO.java)
        * Database (ContactDatabase.java)
    * Repository 
* ViewModel (MyViewModel.java)
* View




 	



**RoomDatabase steps**

1. Include LiveData dependency 
2. Add Room dependencies 
3. Create entity classes 
4. Create DAO interfaces
    * Wrap the necessary return types in the DAO classes that use “@Query and SELECT” with LiveData 
5. Create Database abstract class


**Repository Steps**

1. Create Repository class
    * Room Database Source:
        * Get a RoomDatabase instance in the Constructor.
        * Have an object for each DAO and get an instance in the constructor
        * Each method in the DAOs classes should be mentioned as a method in the repository.
        * The methods calling database operations must be handled by ExecutorService, Handler & Runnable to use a background thread. 
        * The necessary methods calling database queries must return LiveData wrappers. 


**ViewModel Steps**

1. Include ViewModel dependency
*MyViewModel.java*

2. Create a class extending AndroidViewModel
3. Create the necessary LiveData objects
4. Add the necessary methods provided by the Repository. 

*MainActivity.java*

5. Get a ViewModel instance using ViewModelProvider
6. Add observers to the LiveData objects


**RecyclerView steps with DataBinding**

1.  Add DataBinding Dependency
2. Create an AdapterView (RecyclerView) layout (activity_main.xml)
3. Create a custom layout for the items (contact_list_item.xml)
4. Create  a custom Model Class to represent each of the items, a template for  the data we will display in the RecyclerView. (Contacts.java)

5. Modify the layout xml file to bind the Object Variable with the TextView Layout (contact_list_item.xml)

        <layout>
            <data>
                <variable>
* Bind Textview tag ‘text’ attribute with the variable attribute object @{}

*MyAdapter.java*

6. Create a Custom Adapter that extends RecyclerView.Adapter<CustomAdapter.ViewHolder> (MyAdapter.java).
    * Data source
    * ViewHolder Class using DataBinding
        * Create a reference to DataBinding

    * Overridden Methods using DataBinding
        * onCreateViewHolder
        * onBindViewHolder
        * getItemCount()
    * Data Source Setter
        * Call notifyDataSetChanged()

*MainActivity.java*

7. Create a RecyclerView instance and a CustomAdapter instance
8. Define a Layout Manager for the RecyclerView object
9. Link the RecyclerView with the Adapter 
10. Add data to the SourceData
11. Notify changes to the RecyclerView via the Adapter


**Data Binding Steps for Click Events**

1. Create a Button Layout (activity_main.xml)
2. Create the ClickHandler class with onClick(View) method (MainActivityClickHandlers.java)
3. Modify the layout xml file to bind the onClick method to the Button layout (activity_main.xml)

        <layout>
            <data>
                <variable>
    * Bind Button tag ‘onClick’ attribute with the variable method object @{::}

*MainActivity.java*

4. Create a ClickHandler instance and create a reference to DataBinding
5. Link the ViewDataBinding object with a ClickHandler object 




