package com.udacity.gradle.finalproject;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.TimeUnit;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.fail;

/**
 * Created by prittesh on 5/12/16.
 */
@RunWith(AndroidJUnit4.class)
public class syncTest {
    private Context context;

    @Before
    public void set() {
        context = InstrumentationRegistry.getContext();
    }

    @Test
    public void AsyncTest() {

        String joke = null;
        EndpointsAsyncTask asyncTask = new EndpointsAsyncTask();
        asyncTask.execute(context);
        try {
            joke = asyncTask.get(30, TimeUnit.SECONDS);
        } catch (Exception e) {
            fail("Timed out");
        }
        if (joke.equals("connect timed out"))
            fail("Timed out");
    }
}
