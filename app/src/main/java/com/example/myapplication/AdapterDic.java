package com.example.myapplication;

import android.content.Context;
import android.speech.tts.TextToSpeech;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Locale;

import java.util.ArrayList;

public class AdapterDic extends BaseAdapter {
    TextToSpeech t1;
    Context context;
    ArrayList<Dictionary> arrayList;

    public AdapterDic(Context context, ArrayList<Dictionary> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        t1 = new TextToSpeech(context, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR) {
                    t1.setLanguage(Locale.UK);
                }
            }
        });
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.item_dic,null);

        final Dictionary dictionary = arrayList.get(position);

        TextView txtWord = convertView.findViewById(R.id.txtword);
        TextView txtType = convertView.findViewById(R.id.txttype);
        TextView txtMean = convertView.findViewById(R.id.txtmean);
        ImageView imgVoice = convertView.findViewById(R.id.imgvoice);

        txtWord.setText(dictionary.getWord());
        txtType.setText(dictionary.getType());
        txtMean.setText(dictionary.getMeaning());
        imgVoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String toSpeak = dictionary.getPhonectic();
                t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
            }
        });

        return convertView;
    }
}
