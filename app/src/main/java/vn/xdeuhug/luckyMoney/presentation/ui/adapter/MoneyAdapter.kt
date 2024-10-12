package vn.xdeuhug.luckyMoney.presentation.ui.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import vn.xdeuhug.luckyMoney.R
import vn.xdeuhug.luckyMoney.databinding.ItemMoneyBinding
import vn.xdeuhug.luckyMoney.domain.model.Money

/**
 * @Author: NGUYEN XUAN DIEU
 * @Date: 16 / 01 / 2024
 */
class MoneyAdapter(var context: Context) : RecyclerView.Adapter<MoneyAdapter.ViewHolder>() {
    var onClickItem: OnClickItem? = null
    private var listData: List<Money> = emptyList()

    fun setClickItem(onClickItem: OnClickItem) {
        this.onClickItem = onClickItem
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemMoneyBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(data: List<Money>) {
        listData = data
        notifyDataSetChanged()
    }

    private fun getItem(position: Int): Money {
        return listData[position]
    }

    override fun getItemCount(): Int {
        return listData.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBindView(position)
    }


    inner class ViewHolder(private val binding: ItemMoneyBinding) :
        RecyclerView.ViewHolder(binding.root) {
        init {
            binding.btnMinus.setOnClickListener{
                binding.edtNumber.clearFocus()
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    onClickItem!!.onMinus(position, getItem(position))
                }
            }

            binding.btnPlus.setOnClickListener {
                binding.edtNumber.clearFocus()
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    onClickItem!!.onPlus(position, getItem(position))
                }
            }

            binding.edtNumber.addTextChangedListener(object : TextWatcher {
                private var isFormatting = false
                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    if (binding.edtNumber.length() > 2) {
                        binding.edtNumber.setText(
                            binding.edtNumber.text.toString().substring(0, 2)
                        )
                        binding.edtNumber.setSelection(binding.edtNumber.text!!.length)
                        Toast.makeText(
                            context,
                            context.getString(R.string.max_number_99),
                            Toast.LENGTH_SHORT
                        ).show()
                    } else {
                        if (!isFormatting) {
                            if (binding.edtNumber.text.toString().isNotEmpty()) {
                                isFormatting = true
                                binding.edtNumber.removeTextChangedListener(this)
                                binding.edtNumber.setText(
                                    "${
                                        binding.edtNumber.text.toString().toInt()
                                    }"
                                )
                                binding.edtNumber.addTextChangedListener(this)
                                isFormatting = false
                            } else {
                                binding.edtNumber.setText("0")
                            }
                            val position = adapterPosition
                            if (position != RecyclerView.NO_POSITION) {
                                val item = getItem(position)
                                item.money = binding.edtNumber.text.toString().toInt()
                                if (item.money >= 99) {
                                    Toast.makeText(
                                        context,
                                        context.getString(R.string.max_number_99),
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }
                            }

                        }
                        binding.edtNumber.setSelection(binding.edtNumber.text!!.length)
                    }
                }

                override fun afterTextChanged(arg0: Editable?) {
                    //
                }

                override fun beforeTextChanged(
                    s: CharSequence?,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                    //
                }
            })
        }

        @SuppressLint("DiscouragedApi")
        fun onBindView(position: Int) {
            val item = getItem(position)
            binding.edtNumber.setText("${item.money}")
            val imageRes = context.resources.getIdentifier(
                "ic_${item.money}_dong",
                "drawable",
                context.resources.getResourcePackageName(R.drawable.ic_launcher_foreground)
            )
            binding.imvMoney.setImageResource(imageRes)
        }

    }

    interface OnClickItem {
        fun onMinus(position: Int, item: Money)
        fun onPlus(position: Int, item: Money)
    }
}