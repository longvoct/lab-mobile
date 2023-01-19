package com.example.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
//Bai 1
//    private ProgressBar pbFirst, pbSecond;
//    private TextView tvMsgWorking, tvMsgReturned;
//    private boolean isRunning;
//    private int MAX_SEC;
//    private int intTest;
//    private Thread bgThread;
//    private Handler handler;
//    private Button btnStart;
//
//    private void findViewByIds() {
//        pbFirst = (ProgressBar) findViewById(R.id.pb_first);
//        pbSecond = (ProgressBar) findViewById(R.id.pb_second);
//        tvMsgWorking = (TextView) findViewById(R.id.tv_working);
//        tvMsgReturned = (TextView) findViewById(R.id.tv_return);
//        btnStart = (Button) findViewById(R.id.btn_start);
//    }
//
//    private void initVariables() {
//        isRunning = false;
//        MAX_SEC = 20;
//        intTest = 1;
//        pbFirst.setMax(MAX_SEC);
//        pbFirst.setProgress(0);
//
//        //init Views
//        pbFirst.setVisibility(View.GONE);
//        pbSecond.setVisibility(View.GONE);
//
//        handler = new Handler() {
//            @Override
//            public  void handleMessage(Message msg) {
//                super.handleMessage(msg);
//
//                String returnedValue = (String) msg.obj;
//
//                tvMsgReturned.setText(getString(R.string.returned_by_bg_thread) + returnedValue);
//                pbFirst.incrementProgressBy(2);
//
//                if (pbFirst.getProgress() == MAX_SEC) {
//                    tvMsgReturned.setText(getString(R.string.done_background_thread_has_been_stopped));
//                    tvMsgWorking.setText(getString(R.string.done));
//                    pbFirst.setVisibility(View.GONE);
//                    pbSecond.setVisibility(View.GONE);
//                    btnStart.setVisibility(View.VISIBLE);
//                    isRunning = false;
//                } else {
//                    tvMsgWorking.setText(getString(R.string.working) + pbFirst.getProgress());
//                }
//            }
//        };
//    };
//
//    private  void initBgThread() {
//        bgThread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    for (int i = 0; i < MAX_SEC && isRunning; i++) {
//                        Thread.sleep(1000); //sleep 1s
//
//                        Random rnd = new Random();
//
//                        String data = "Thread value: " + (int) rnd.nextInt(101);
//
//                        data += getString(R.string.global_value_seen) + " " + intTest;
//                        intTest++;
//
//                        if(isRunning) {
//                            Message msg = handler.obtainMessage(1, (String) data);
//                            handler.sendMessage(msg);
//                        }
//                    }
//                }
//                catch (Throwable t) {
//
//                }
//            }
//        });
//    }
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        findViewByIds();
//        initVariables();
//
//        btnStart.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                isRunning = true;
//                pbFirst.setVisibility(View.VISIBLE);
//                pbSecond.setVisibility(View.VISIBLE);
//                btnStart.setVisibility(View.GONE);
//                bgThread.start();
//            }
//        });
//    };
//
//    @Override
//    protected void onStart() {
//        super.onStart();
//        initBgThread();
//    }
//
//    @Override
//    protected void onStop() {
//        super.onStop();
//        isRunning = false;
//    }

    //Bai 2
//    private ProgressBar pbWaiting;
//    private TextView tvTopCaption;
//    private EditText etInput;
//    private Button btnExecute;
//    private int globalValue, accum;
//    private long startTime;
//    private final String PATIENCE = "Some important data is being collected now.\nPlease be patient...wait...";
//    private Handler handler;
//    private Runnable fgRunnable, bgRunnable;
//    private Thread testThread;
//
//    private void findViewByIds() {
//        tvTopCaption = (TextView) findViewById(R.id.tv_top_caption);
//        pbWaiting = (ProgressBar) findViewById(R.id.pb_waiting);
//        etInput = (EditText) findViewById(R.id.et_input);
//        btnExecute = (Button) findViewById(R.id.btn_execute);
//    }
//
//    private void initVariables() {
//        globalValue = 0;
//        accum = 0;
//        startTime = System.currentTimeMillis();
//
//        handler = new Handler();
//
//        fgRunnable = new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    int progressStep = 5;
//                    double totalTime = (System.currentTimeMillis() - startTime) / 1000;
//                    synchronized (this) {
//                        globalValue += 100;
//                    }
//
//                    // Update UI
//                    tvTopCaption.setText(PATIENCE + totalTime + " - " + globalValue);
//                    pbWaiting.incrementProgressBy(progressStep);
//                    accum += progressStep;
//
//                    // Check to stop
//                    if (accum >= pbWaiting.getMax()) {
//                        tvTopCaption.setText(getString(R.string.bg_work_is_over));
//                        pbWaiting.setVisibility(View.GONE);
//                    }
//                } catch (Exception e) {
//                    Log.e("fgRunnable", e.getMessage());
//                }
//            }
//        };
//
//        bgRunnable = new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    for (int i = 0; i < 20; i++) {
//                        Thread.sleep(1000); //sleep 1s
//
//                        synchronized (this) {
//                            globalValue += 1;
//                        }
//
//                        handler.post(fgRunnable);
//                    }
//                }
//                catch (Exception e) {
//                    Log.e("bgRunnable", e.getMessage());
//                }
//            }
//        };
//        testThread = new Thread(bgRunnable);
//    };
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main2);
//
//        findViewByIds();
//        initVariables();
//
//        btnExecute.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String input = etInput.getText().toString();
//                Toast.makeText(MainActivity.this, "You said: " + input, Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        testThread.start();
//        pbWaiting.incrementProgressBy(0);
//    }

    //Bai 3
    private Button btnQuickJob, btnSlowJob;
    private TextView tvStatus;
    private SlowTask slowTask;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        findViewByIds();
        // Init slowtask
        slowTask=new SlowTask(MainActivity.this, tvStatus);
        // Handle onClickListenner
        btnQuickJob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                tvStatus.setText(sdf.format(new Date()));
            }
        });
        btnSlowJob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                slowTask.execute();
            }
        });
    }
    private void findViewByIds() {
        btnQuickJob = (Button) findViewById(R.id.btn_quick_job);
        btnSlowJob = (Button) findViewById(R.id.btn_slow_job);
        tvStatus = (TextView) findViewById(R.id.tv_status);
    }

}