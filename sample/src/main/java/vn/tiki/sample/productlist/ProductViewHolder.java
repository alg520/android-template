package vn.tiki.sample.productlist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import vn.tiki.noadapter2.AbsViewHolder;
import vn.tiki.sample.GlideApp;
import vn.tiki.sample.R;
import vn.tiki.sample.entity.Product;
import vn.tiki.sample.util.TextViews;

public class ProductViewHolder extends AbsViewHolder {
  @BindView(R.id.ivThumb) ImageView ivThumb;
  @BindView(R.id.tvTitle) TextView tvTitle;
  @BindView(R.id.tvPrice) TextView tvPrice;

  private ProductViewHolder(View itemView) {
    super(itemView);
    ButterKnife.bind(this, itemView);
  }

  public static ProductViewHolder create(ViewGroup parent) {
    final LayoutInflater inflater = LayoutInflater.from(parent.getContext());
    final View view = inflater.inflate(R.layout.productlist_item_product, parent, false);
    return new ProductViewHolder(view);
  }

  @Override public void bind(Object item) {
    super.bind(item);
    if (!(item instanceof Product)) {
      return;
    }

    final Product product = (Product) item;

    tvTitle.setText(product.title());
    TextViews.setPrice(tvPrice, product.price());
    GlideApp
        .with(itemView.getContext())
        .load(product.imageUrl())
        .centerCrop()
        .placeholder(R.drawable.ic_placeholder)
        .into(ivThumb);
  }
}
