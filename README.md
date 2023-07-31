
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

