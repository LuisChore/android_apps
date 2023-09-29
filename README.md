
## Lucky Number App

**Description**: In the main screen the user enters their name, after clicking the button another screen opens with a lucky number assigned to the user and the option to share it.

**Android Topics**: 

* Explicit Intent: Sharing data between activities.
* Implicit Intent: Sharing information between applications.


## Music Player App

**Description**: App that allows us to play media(Audio) files stored in the application resources directory with the help of  the Android Multimedia Framework. 

**Android Topics**: 

* Vector Assets: To create default icons for our application. 
* Media Player: To control media in Android Studio. 
* Seekbar(Widget): To display the progress of the media playing. 
* Handler(postDelayed): To manage in a Thread the seekbar. 

## Video Player App

**Description**: App that allows us to play videos either stored in the application resources directory or videos fetched from the web. 

**Android Topics**: 

* VideoView (Widget): To display video content  from different sources. 
* MediaController (View): To control the media player.

## French Teacher App

**Description**: App to Learn the colors in  French using Audio Files.

**Android Topics**:

* colors.xml: To define colors in our resources directory. 
* raw/: To save raw files (audio).
* Media Player: To control media files in Android Studio. 

## World Cup App

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
 
## Vaccines App

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


## Top Games App

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


## Learning Management App

**Description**: App that displays data from a database and  manages (create, update, delete) a list of courses for each category in a Spinner. App created using the MVVM pattern.
	
**Android Topics**: 
* Room Database: Database, an abstraction layer over SQLite.
* Repository Pattern:  Design pattern that isolates the data layer from the rest of the app. 
* ViewModel: It manages the data for the UI. It exposes state to the UI and encapsulates related business logic.
* LiveData: Observable data holder class, to update UI components when the underlying data changes using the Observer Pattern.
* Data Binding: To bind UI components in layouts to data sources in your app.
* Spinner: View used to select one value from a dropdown menu.
* ItemTouchHelper. Utility to add ‘swipe to dismiss’ or ‘drag & drop’ for the RecyclerView 

#### MVVM steps
* Model
  * Room Database 
    * Entities {Category,Course}
    * DataAccessObjects {CourseDAO, CategoryDAO}
    * Database (Singleton Pattern) {CourseDatabase}
  * Repository {CourseShopRepository}
* ViewModel 
  * ViewModelActivity {MainActivityViewModel}
  * LiveData
* View
  * Activities {MainActivity,AddEditActivity}
  * Adapters {CourseAdapter}

#### Data Binding Steps for Click Events
1. Create a Button Layout 
2. Create the ClickHandlerClass with onClick method
3. Modify the layout xml file (<layout> <data> <variable>)
4. Connect a DataBinding object with the handler object in the Activity 

#### Spinner Steps using data binding
1. Create a Spinner Layout (content_main.xml)
2. Create a Spinner Item Layout that defines how the selected choice appears in the spinner (spinner_item.xml)
3. Create an ArrayAdapter that receives the data source and provides the spinner choices. (MainActivity)
4. Create the ClickHanlderClass with the onItemSelected method  (MainActivity)
5. Modify the layout xml file (<layout> <data> <variable>) to bind the adapter attribute to the Spinner tag. (content_main.xml)
6. Connect the DataBinding object with the handler object in the Activity  (MainActivity)


#### RecyclerView using Data Binding
1. Create  in the main_activity.xml an AdapterView (RecyclerView).
2. Create  a custom layout for the items (recyclerview_item).
3. Modify the layout xml file (<layout> <data> <variable>) to attach the object variable with the TextView layouts. 
4. Create  a Custom Model Class to represent each of the items. A template for  the data we will pass (Course).
5. Create a Custom Adapter that extends RecyclerView.Adapter<CustomAdapter.ViewHolder> (CustomAdapter).
  * Data source
  * ViewHolder Class
  * Implement Override Methods
  * Add click Event Listener in the ViewHolder constructor 

#### Get result from an activity (start an activity and receive a result back)
* From Main Activity start the Second Activity for a result back using startActivityForResult (MainActivity)
* Return some value from Second Activity using setResult (AddEditActivity)
* Collect data from the Main Activity using onActivityResult (MainActivity) 

## Movie Pro App

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



