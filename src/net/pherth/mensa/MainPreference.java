/*
Copyright (c) 2012, Phillip Thelen
All rights reserved.

Redistribution and use in source and binary forms, with or without
modification, are permitted provided that the following conditions are met: 

1. Redistributions of source code must retain the above copyright notice, this
   list of conditions and the following disclaimer. 
2. Redistributions in binary form must reproduce the above copyright notice,
   this list of conditions and the following disclaimer in the documentation
   and/or other materials provided with the distribution. 

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
(INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
(INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/

package net.pherth.mensa;

import net.pherth.mensa.R;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockPreferenceActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;
 
public class MainPreference extends SherlockPreferenceActivity {
        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                addPreferencesFromResource(R.xml.mainpreferences);
                ActionBar actionBar = getSupportActionBar();
                actionBar.setDisplayShowTitleEnabled(true);
                actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.action_bar));
                actionBar.setDisplayShowHomeEnabled(false);
                
                CharSequence entry;
                Preference mensaPref = (Preference) findPreference("mensaPreference");
                mensaPref.setOnPreferenceChangeListener(setListListener());
                entry = ((ListPreference) mensaPref).getEntry();
        		mensaPref.setSummary(entry);
                Preference pricePref = (Preference) findPreference("priceCategory");
                pricePref.setOnPreferenceChangeListener(setListListener());
                entry = ((ListPreference) pricePref).getEntry();
        		pricePref.setSummary(entry);
                
        }
        
        
        private OnPreferenceChangeListener setListListener(){

        	OnPreferenceChangeListener listener = new OnPreferenceChangeListener() {
				@Override
				public boolean onPreferenceChange(
					Preference arg0, Object arg1) {
						int index = ((ListPreference) arg0).findIndexOfValue(arg1.toString());
						CharSequence summary = ((ListPreference) arg0).getEntries()[index];
                		arg0.setSummary(summary);
                		return true;
					}
        	};
        	return listener;
        }
        
        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
        	//MenuInflater inflater = getSupportMenuInflater();
            //inflater.inflate(R.menu.preferencemenu, menu);
            return true;
        }
        
        
        
        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            /* switch (item.getItemId()) {
                case R.id.menu_save:
                	if (getParent() == null) {
                	    setResult(Activity.RESULT_OK);
                	} else {
                	    getParent().setResult(Activity.RESULT_OK);
                	}
                	finish();
                    break;
                	
            }*/
            return true;
        }
}
