package yazdaniscodelab.bottomnavigationview;


import android.app.Fragment;
import android.support.annotation.NonNull;

import android.support.design.widget.BottomNavigationView;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView navigationItemView;
    private FrameLayout frameLayout;


    //fragment

    private HomeFragment homefragment;
    private CartFragment cartFragment;
    private NotificationFragment notificationFragment;

    


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navigationItemView=findViewById(R.id.bottomNavigationView);
        frameLayout=findViewById(R.id.main_frame);


        homefragment=new HomeFragment();
        cartFragment=new CartFragment();
        notificationFragment=new NotificationFragment();

        setFragment(homefragment);

        navigationItemView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {

                    case R.id.home:
                        navigationItemView.setItemBackgroundResource(R.color.home);
                        setFragment(homefragment);
                        
                    return true;

                    case R.id.cart:
                        navigationItemView.setItemBackgroundResource(R.color.cart);

                        setFragment(cartFragment);
                    return true;


                    case R.id.notification:
                        navigationItemView.setItemBackgroundResource(R.color.notification);

                        setFragment(notificationFragment);
                    return true;


                    default:
                        return false;


                }

            }


        });


    }

    private void setFragment(android.support.v4.app.Fragment fragment) {

       FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_frame,fragment);
        fragmentTransaction.commit();


    }


}
