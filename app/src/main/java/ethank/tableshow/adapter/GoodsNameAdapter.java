package ethank.tableshow.adapter;

import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import ethank.tableshow.R;
import ethank.tableshow.modle.Good;

/**
 * Created by ping on 2017/2/16.
 */

public class GoodsNameAdapter extends BaseQuickAdapter<Good, BaseViewHolder> {


    public GoodsNameAdapter(List<Good> data) {
        super(R.layout.adapter_good_name, data);
    }

    @Override
    protected void convert(BaseViewHolder holder, Good good) {
        holder.setText(R.id.tv_goodname, good.getGoodName());
    }
}
