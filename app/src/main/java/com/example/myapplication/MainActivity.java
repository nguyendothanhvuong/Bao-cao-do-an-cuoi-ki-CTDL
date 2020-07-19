package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Hashtable;
// khởi tạo
public class MainActivity extends AppCompatActivity {
    Hashtable<String,ArrayList<Dictionary>> hashtable;
    EditText edtSearch;
    Button btnClear;
    ListView lvDic;
    AdapterDic adapterDic;
    ArrayList<Dictionary> dictionaryArrayList;
    ArrayList<Dictionary> dictionaryArrayListClone;
    ArrayList<Dictionary> dictionaryArrayListEmpty;
    ArrayList<Dictionary> dictionaryArrayListA,dictionaryArrayListB,dictionaryArrayListC,dictionaryArrayListD,dictionaryArrayListE,dictionaryArrayListF,
            dictionaryArrayListG,dictionaryArrayListH,dictionaryArrayListI,dictionaryArrayListK,dictionaryArrayListL,dictionaryArrayListM,
            dictionaryArrayListN,dictionaryArrayListO,dictionaryArrayListP,dictionaryArrayListQ,dictionaryArrayListW,dictionaryArrayListR,dictionaryArrayListV,
            dictionaryArrayListT,dictionaryArrayListY,dictionaryArrayListU,dictionaryArrayListS,dictionaryArrayListJ,dictionaryArrayListZ,dictionaryArrayListX;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtSearch = findViewById(R.id.txt_search);
        btnClear = findViewById(R.id.btn_clear_search);
        lvDic = findViewById(R.id.lv_dictonaty);
        addDatatoHashTable();



        dictionaryArrayList = new ArrayList<Dictionary>();
        dictionaryArrayListEmpty = new ArrayList<Dictionary>();
        adapterDic = new AdapterDic(MainActivity.this,dictionaryArrayList);
        lvDic.setAdapter(adapterDic);

        edtSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.d("size", s + "+" + count);
                addDatatoArray(s,count);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtSearch.setText("");
                adapterDic = new AdapterDic(MainActivity.this,dictionaryArrayListEmpty);
                lvDic.setAdapter(adapterDic);

            }
        });
    }

    private void addDatatoArray(CharSequence s,int count) {
        if (count==1){
            // add mang dictonary loc duoc tu hash table
            Log.d("hs","add mang loc tu hash table");
            dictionaryArrayList = hashtable.get(s.toString());

            adapterDic = new AdapterDic(MainActivity.this,dictionaryArrayList);
            lvDic.setAdapter(adapterDic);
        }
        else {
            if (edtSearch.getText().toString().equals("")){
                Log.d("hs",s.toString()+ "mang rong ");
                adapterDic = new AdapterDic(MainActivity.this,dictionaryArrayListEmpty);
                lvDic.setAdapter(adapterDic);
            }else {
                // search s trong arr da duoc add
                Log.d("hs",s.toString()+ "search s trong arr da duoc add ");
                dictionaryArrayListClone = new ArrayList<Dictionary>();
                for (int i=0;i<dictionaryArrayList.size();i++){
                    if (dictionaryArrayList.get(i).getWord().contains(s)){

                        dictionaryArrayListClone.add(new Dictionary(
                                dictionaryArrayList.get(i).getWord(),
                                dictionaryArrayList.get(i).getType(),
                                dictionaryArrayList.get(i).getPhonectic(),
                                dictionaryArrayList.get(i).getMeaning()
                        ));
                    }
                }
                adapterDic = new AdapterDic(this,dictionaryArrayListClone);
                lvDic.setAdapter(adapterDic);
            }
        }
        adapterDic.notifyDataSetChanged();

    }
    private void addDatatoHashTable() {
        dictionaryArrayListA = new ArrayList<Dictionary>();
        dictionaryArrayListA.add(new Dictionary("apple","N","apple","quả táo"));
        dictionaryArrayListA.add(new Dictionary("application","N","application","ứng dụng"));
        dictionaryArrayListA.add(new Dictionary("alone","N","alone","cô đơn"));
        dictionaryArrayListA.add(new Dictionary("abase","V","abase","làm mất thể diện, làm nhục"));
        dictionaryArrayListA.add(new Dictionary("agreement","N","agreement","thoả thuận, hợp đồng"));
        dictionaryArrayListA.add(new Dictionary("assurance","N","assurance","đảm bảo"));


        dictionaryArrayListB = new ArrayList<Dictionary>();
        dictionaryArrayListB.add(new Dictionary("banana","N","banana","quả chuối"));
        dictionaryArrayListB.add(new Dictionary("button","N","button","nút"));
        dictionaryArrayListB.add(new Dictionary("bottom","N","bottom","ở dưới"));
        dictionaryArrayListB.add(new Dictionary("before","Adv","before","đằng trước"));
        dictionaryArrayListB.add(new Dictionary("beach","N","beach","bãi biển"));
        dictionaryArrayListB.add(new Dictionary("beak","N","beak","vòi ấm, mỏ (chim)"));

        dictionaryArrayListC = new ArrayList<Dictionary>();
        dictionaryArrayListC.add(new Dictionary("cat","N","cat","con mèo"));
        dictionaryArrayListC.add(new Dictionary("cut","V","cut","cắt"));
        dictionaryArrayListC.add(new Dictionary("centre","N","centre","trung tâm"));
        dictionaryArrayListC.add(new Dictionary("cab","N","cab","xe taxi"));
        dictionaryArrayListC.add(new Dictionary("cube","N","cube","hình khối"));
        dictionaryArrayListC.add(new Dictionary("cicada","N","cicada","con ve sầu"));


        dictionaryArrayListD = new ArrayList<Dictionary>();
        dictionaryArrayListD.add(new Dictionary("dad","N","dad","ba, cha, bố"));
        dictionaryArrayListD.add(new Dictionary("dacoity","N","dacoity","sự cướp bóc"));
        dictionaryArrayListD.add(new Dictionary("dace","N","dace","cá đát"));
        dictionaryArrayListD.add(new Dictionary("delete","V","delete","xoá"));
        dictionaryArrayListD.add(new Dictionary("dick","N","dick","thám tử"));
        dictionaryArrayListD.add(new Dictionary("diabase","N","diabase","khoáng chất"));


        dictionaryArrayListE = new ArrayList<Dictionary>();
        dictionaryArrayListE.add(new Dictionary("each","Adj","each","mỗi"));
        dictionaryArrayListE.add(new Dictionary("eager","Adj","eager","háo hức, hăm hở, ham muốn hoặc thiết tha"));
        dictionaryArrayListE.add(new Dictionary("eagerness","N","eagerness","sự háo hức, sự hăm hở, sự say mê"));
        dictionaryArrayListE.add(new Dictionary("eagle","N","eagle","chim đại bàng"));
        dictionaryArrayListE.add(new Dictionary("ebb","N","ebb","(the ebb) (về thủy triều) đang xuống"));
        dictionaryArrayListE.add(new Dictionary("ebon","Adj","ebon","thơ ca"));

        dictionaryArrayListF = new ArrayList<Dictionary>();
        dictionaryArrayListF.add(new Dictionary("fable","N","fable","nhà viết truyện ngụ ngôn"));
        dictionaryArrayListF.add(new Dictionary("face","N","face","mặt"));
        dictionaryArrayListF.add(new Dictionary("father","N","father","cha, ba"));
        dictionaryArrayListF.add(new Dictionary("fish","N","fish","con cá"));
        dictionaryArrayListF.add(new Dictionary("foam","N","foam","bọt nước"));
        dictionaryArrayListF.add(new Dictionary("fictional","Adj","fictional","hư cấu"));

        dictionaryArrayListG = new ArrayList<Dictionary>();
        dictionaryArrayListG.add(new Dictionary("game","N","game","game"));
        dictionaryArrayListG.add(new Dictionary("gadder","N","gadder","máy khoan"));
        dictionaryArrayListG.add(new Dictionary("giant","N","giant","người khổng lồ"));

        dictionaryArrayListH = new ArrayList<Dictionary>();
        dictionaryArrayListH.add(new Dictionary("habit","N","habit","thói quen, tập quán"));
        dictionaryArrayListH.add(new Dictionary("hour","N","hour","giờ"));
        dictionaryArrayListH.add(new Dictionary("home","N","home","nhà, gia đình"));

        dictionaryArrayListI = new ArrayList<Dictionary>();
        dictionaryArrayListI.add(new Dictionary("inter","V","inter","chôn cất, mai táng"));
        dictionaryArrayListI.add(new Dictionary("ice","N","ice","băng, nước đá"));
        dictionaryArrayListI.add(new Dictionary("image","N","image","hình ảnh"));

        dictionaryArrayListK = new ArrayList<Dictionary>();
        dictionaryArrayListK.add(new Dictionary("kali","N","kali","cây muối"));
        dictionaryArrayListK.add(new Dictionary("know","V","know","hiểu biết"));
        dictionaryArrayListK.add(new Dictionary("kid","N","kid","con dê non"));

        dictionaryArrayListL = new ArrayList<Dictionary>();
        dictionaryArrayListL.add(new Dictionary("label","N","label","nhãn hiệu"));
        dictionaryArrayListL.add(new Dictionary("local","Adj","local","thuộc về một nơi nào đó"));
        dictionaryArrayListL.add(new Dictionary("look","V","look","nhìn, xem"));

        dictionaryArrayListM = new ArrayList<Dictionary>();
        dictionaryArrayListM.add(new Dictionary("mother","N","mother","mẹ"));
        dictionaryArrayListM.add(new Dictionary("month","N","month","tháng"));
        dictionaryArrayListM.add(new Dictionary("mean","N","mean","điều kiện, tính chất"));

        dictionaryArrayListN = new ArrayList<Dictionary>();

        dictionaryArrayListO = new ArrayList<Dictionary>();

        dictionaryArrayListP = new ArrayList<Dictionary>();

        dictionaryArrayListQ = new ArrayList<Dictionary>();
        dictionaryArrayListW = new ArrayList<Dictionary>();
        dictionaryArrayListR = new ArrayList<Dictionary>();
        dictionaryArrayListV = new ArrayList<Dictionary>();
        dictionaryArrayListT = new ArrayList<Dictionary>();
        dictionaryArrayListY = new ArrayList<Dictionary>();
        dictionaryArrayListU = new ArrayList<Dictionary>();
        dictionaryArrayListS = new ArrayList<Dictionary>();
        dictionaryArrayListJ = new ArrayList<Dictionary>();
        dictionaryArrayListZ = new ArrayList<Dictionary>();
        dictionaryArrayListX = new ArrayList<Dictionary>();

        hashtable = new Hashtable<String,ArrayList<Dictionary>>();

        hashtable.put("a", dictionaryArrayListA);
        hashtable.put("b", dictionaryArrayListB);
        hashtable.put("c", dictionaryArrayListC);
        hashtable.put("d", dictionaryArrayListD);
        hashtable.put("e", dictionaryArrayListE);
        hashtable.put("f", dictionaryArrayListF);
        hashtable.put("g", dictionaryArrayListG);
        hashtable.put("h", dictionaryArrayListH);
        hashtable.put("i", dictionaryArrayListI);
        hashtable.put("k", dictionaryArrayListK);
        hashtable.put("l", dictionaryArrayListL);
        hashtable.put("m", dictionaryArrayListM);
        hashtable.put("n", dictionaryArrayListN);
        hashtable.put("o", dictionaryArrayListO);
        hashtable.put("p", dictionaryArrayListP);
        hashtable.put("q", dictionaryArrayListQ);
        hashtable.put("w", dictionaryArrayListW);
        hashtable.put("r", dictionaryArrayListR);
        hashtable.put("v", dictionaryArrayListV);
        hashtable.put("t", dictionaryArrayListT);
        hashtable.put("y", dictionaryArrayListY);
        hashtable.put("u", dictionaryArrayListU);
        hashtable.put("s", dictionaryArrayListS);
        hashtable.put("j", dictionaryArrayListJ);
        hashtable.put("z", dictionaryArrayListZ);
        hashtable.put("x", dictionaryArrayListX);

    }
}
