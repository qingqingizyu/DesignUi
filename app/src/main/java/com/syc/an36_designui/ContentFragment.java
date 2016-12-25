package com.syc.an36_designui;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContentFragment extends Fragment {

    //创建Fragment对象
    public static Fragment createInstance(String name) {
        ContentFragment fragment = new ContentFragment();
        Bundle args = new Bundle();
        args.putString("name", name);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_content, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView tvMsg = (TextView) view.findViewById(R.id.tv_msg);
        RecyclerView mView = (RecyclerView) view.findViewById(R.id.recyler_view);

        Bundle bundle = getArguments();
        String msg;
        if (bundle != null) {
            msg = bundle.getString("name");
        } else {
            msg = "数据为空";
        }
        tvMsg.setText(msg);

        String[] logos = new String[]{"p1", "p2", "p3", "p4", "p5", "p6", "p7", "p8"};
        final List<Map<String, String>> mList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Map<String, String> map = new HashMap<>();
            if (i < 10) {
                map.put("name", "美女0" + i);
            } else {
                map.put("name", "美女" + i);
            }
            map.put("logo", logos[i % logos.length]);
            mList.add(map);
        }

        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        mView.setLayoutManager(manager);
        //设置适配器
        ContentAdapter adapter = new ContentAdapter(getActivity(), mList);
        mView.setAdapter(adapter);

        //点击事件
        adapter.setOnRecyclerViewItemClickListener(new ContentAdapter.OnRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(getActivity(), DetailActivity.class);
                intent.putExtra("name", mList.get(position).get("name"));
                intent.putExtra("logo", mList.get(position).get("logo"));
                startActivity(intent);
            }
        });
    }
}
