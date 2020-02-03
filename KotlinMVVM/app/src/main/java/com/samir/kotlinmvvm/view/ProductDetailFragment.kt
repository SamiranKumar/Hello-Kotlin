package com.samir.kotlinmvvm.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.samir.kotlinmvvm.ProductFamily
import com.samir.kotlinmvvm.R


class ProductDetailFragment : androidx.fragment.app.Fragment() {

    lateinit var product: ProductFamily

    companion object {
        const val KEY_PRODUCT = "KEY_PRODUCT"

        fun newInstance(productFamily: ProductFamily): ProductDetailFragment {
            val args = Bundle()
            args.putSerializable(KEY_PRODUCT, productFamily)
            val fragment = ProductDetailFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let { product = it.getSerializable(KEY_PRODUCT) as ProductFamily }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_vehicle, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view?.findViewById<androidx.recyclerview.widget.RecyclerView>(R.id.recyclerView)
        recyclerView!!.layoutManager =
            androidx.recyclerview.widget.LinearLayoutManager(
                view!!.context,
                LinearLayout.VERTICAL,
                false
            )
        var productDetailAdapter: ProductDetailAdapter = ProductDetailAdapter(product)
        recyclerView.adapter = productDetailAdapter

    }
}