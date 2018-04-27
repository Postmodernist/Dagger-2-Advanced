package com.hariofspades.dagger2advanced.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.hariofspades.dagger2advanced.R;
import com.hariofspades.dagger2advanced.model.Result;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RandomUserAdapter extends RecyclerView.Adapter<RandomUserAdapter.RandomUserViewHolder> {

  private List<Result> results;
  private Context context;

  public RandomUserAdapter(Context context) {
    this.context = context;
  }

  @NonNull
  @Override
  public RandomUserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    LayoutInflater inflater = LayoutInflater.from(context);
    View view = inflater.inflate(R.layout.list_item_random_user, parent, false);
    return new RandomUserViewHolder(view);
  }

  @Override
  public void onBindViewHolder(@NonNull RandomUserViewHolder holder, int position) {
    if (results == null) {
      return;
    }
    Result result = results.get(position);
    final String firstName = result.getName().getFirst();
    final String lastName = result.getName().getLast();
    final String largePicture = result.getPicture().getLarge();

    holder.textView.setText(context.getString(R.string.user_name_format, firstName, lastName));
    Picasso.get().load(largePicture).into(holder.imageView);
  }

  @Override
  public int getItemCount() {
    return results == null ? 0 : results.size();
  }

  public void setItems(List<Result> results) {
    this.results = results;
    notifyDataSetChanged();
  }

  class RandomUserViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.name)
    TextView textView;

    @BindView(R.id.image)
    ImageView imageView;

    RandomUserViewHolder(View itemView) {
      super(itemView);
      ButterKnife.bind(this, itemView);
    }
  }
}
