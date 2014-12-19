package cn.wh.xwm;

import cn.wh.xwm.R;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class SaveActivity extends Activity {
    /** Called when the activity is first created. */
	final String[] savedata = {"2012-06-01","2012-06-02","2012-06-03","2012-06-04","2012-06-05"};
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.save);
        ListView list_save = (ListView)findViewById(R.id.list_save);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,savedata);
        list_save.setAdapter(adapter);
    }

}