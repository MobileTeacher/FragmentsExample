package br.com.contapra2.contapra2;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{


    String currentText = "Fragmento inicial";
    DrawerLayout drawer;
    FragmentPagerAdapter pagerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_drawer_layout);

        drawer = findViewById(R.id.drawer);

        changeFragment(currentText);


        NavigationView navigationView = findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(Gravity.START)){
            drawer.closeDrawer(Gravity.START);
        }
        super.onBackPressed();
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        drawer.closeDrawer(Gravity.START);
        int itemId = item.getItemId();
        switch (itemId){
            case R.id.cool_fragment:
            case R.id.black_fragment:
            case R.id.lost_fragment:
                if (!currentText.equals(item.getTitle().toString())){
                    changeFragment(item.getTitle().toString());
                }
                break;
            default:
                Toast.makeText(this, "Escolha inválida!", Toast.LENGTH_SHORT).show();
        }

        return true;
    }

    private void changeFragment(String message){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        TextFragment textFragment = TextFragment.newInstance(message);
        transaction.replace(R.id.main_fragment, textFragment);
        transaction.commit();
        currentText = message;
    }
}
