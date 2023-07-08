
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
 

