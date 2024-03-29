package com.example.mvvmsample.viewModels;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModel;

import com.example.mvvmsample.data.AppDataManager;
import com.example.mvvmsample.data.api.AppApiHelper;
import com.example.mvvmsample.data.models.UserResponse;
import com.example.mvvmsample.data.prefs.AppPreferencesHelper;
import com.example.mvvmsample.retrofit.RetrofitClient;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainViewModel extends AndroidViewModel {

    private static final String TAG = "MainViewModel";

    AppDataManager appDataManager;
    private Context context;



    public MainViewModel(@NonNull Application application) {
        super(application);
        this.context = application.getApplicationContext();
        this.appDataManager = AppDataManager.getInstance(context);
        Log.d(TAG, "MainViewModel: " +(this.appDataManager == null));

    }

    public void getUsers(){
        
        appDataManager.getUserList().subscribeOn(Schedulers.io()).
                observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Response<UserResponse>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.d(TAG, "onSubscribe: ");
                    }

                    @Override
                    public void onNext(Response<UserResponse> userResponseResponse) {
                        Log.d(TAG, "onNext: " + userResponseResponse.toString());
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "onError: ",e );
                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "onComplete:");
                    }
                });
        
        
    }


}
