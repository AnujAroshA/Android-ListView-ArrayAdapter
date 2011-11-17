package blog.anuja.android;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class FirstActivity extends Activity {
	
	// Declare the UI components
	private ListView songsListView;
	
	// Declare an array to store data to fill the list
	private String[] songsArray ;
	
	// Declare an ArrayAdapter that we use to join the data set and the ListView
	//<String> is the way of type safe, means you only can pass Strings to this array
	//Anyway ArrayAdapter supports only TextView
	private ArrayAdapter<String> arrayAdapter;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        // Initialize the UI components
        songsListView = (ListView) findViewById(R.id.songsListView);
        
        // Initialize the songs array
        songsArray = new String[10];
        
        // Fill the songs array by using a for loop
        for(int i=0; i < songsArray.length; i++){
        	songsArray[i] = "Song " + i;
        }
        
        // For this moment, you have list of songs and a ListView where you can display a list.
        //But how can we put this data set to the list?
        //This is where you need an Adapter
        
        //context -  The current context. 
        //resource - The resource ID for a layout file containing a layout to use when instantiating views. 
        //textViewResourceId - The id of the TextView within the layout resource to be populated  
        //From the third parameter, you plugged the data set to adapter
        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, songsArray);
        
        // By using setAdapter method, you plugged the ListView with adapter
        songsListView.setAdapter(arrayAdapter);
        
        // Normally the argument of setAdapter ask for a ListAdapter instance.
        //And that is the best way of implementation of this code
        //We call it "programming to the interface"
    }
}