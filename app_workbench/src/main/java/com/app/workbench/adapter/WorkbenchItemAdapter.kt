package com.app.workbench.adapter

import android.widget.ImageView
import com.app.extension.loadImage
import com.app.workbench.R
import com.app.workbench.bean.WorkbenchItem
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder

/**
 * 工作台 适配器
 */
class WorkbenchItemAdapter :
    BaseQuickAdapter<WorkbenchItem, BaseViewHolder>(R.layout.workbench_item_adapter) {

    override fun convert(holder: BaseViewHolder, item: WorkbenchItem) {
        holder.setText(R.id.tvName, item.name)
        holder.getView<ImageView>(R.id.ivIcon).loadImage(item.src)
    }

}