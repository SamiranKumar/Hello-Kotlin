package com.samir.kotlinmvvm.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.lifecycle.Observer
import com.samir.kotlinmvvm.ProductFamily
import com.samir.kotlinmvvm.ProductViewModel
import com.samir.kotlinmvvm.R

import org.koin.android.viewmodel.ext.android.viewModel

class ProductListFragment : androidx.fragment.app.Fragment() {

    private val productListModel: ProductViewModel by viewModel()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_vehicle_list, container, false)
    }


    override fun onStart() {
        super.onStart()

        val recyclerView = view?.findViewById<androidx.recyclerview.widget.RecyclerView>(R.id.recyclerView)
        recyclerView!!.layoutManager =
            androidx.recyclerview.widget.LinearLayoutManager(
                view!!.context,
                LinearLayout.VERTICAL,
                false
            )


        productListModel.getProducts()
        productListModel.listOfProducts.observe(this, Observer(function = fun(productList: List<ProductFamily>?) {
            productList?.let {

                var productListAdapter: ProductListAdapter = ProductListAdapter(productList)
                recyclerView.adapter = productListAdapter
                productListAdapter.setItemClickListener(object : ProductListAdapter.ItemClickListener {
                    override fun onItemClick(view: View, position: Int) {
                        val newFragment = ProductDetailFragment.newInstance(productList.get(position))
                        val transaction = fragmentManager!!.beginTransaction()
                        transaction.replace(R.id.frag_container, newFragment)
                        transaction.addToBackStack(null)
                        transaction.commit()
                    }
                })
            }
        }))
    }


}
