package ethank.tableshow.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import ethank.tableshow.R;
import ethank.tableshow.modle.Good;

/**
 * Created by ping on 2017/2/16.
 */

public class GoodsDetailAdapter extends BaseQuickAdapter<Good, BaseViewHolder> {
    public GoodsDetailAdapter(List<Good> data) {
        super(R.layout.adapter_good_detil, data);
    }

    @Override
    protected void convert(BaseViewHolder holder, Good good) {
        holder.setText(R.id.tv_goodBar, good.getGoodBar());
        holder.setText(R.id.tv_goodClasses, good.getGoodClasses());
        holder.setText(R.id.tv_goodStandard, good.getGoodStandard());
        holder.setText(R.id.tv_goodUnit, good.getGoodUnit());
        holder.setText(R.id.tv_goodSupplier, good.getGoodSupplier());
        holder.setText(R.id.tv_goodPrice, good.getGoodPrice());
        holder.setText(R.id.tv_goodQuality, good.getGoodQuality());
        holder.setText(R.id.tv_goodPurchaseDate, good.getGoodPurchaseDate());
        holder.setText(R.id.tv_goodBuyPrice, good.getGoodBuyPrice());
    }
}
