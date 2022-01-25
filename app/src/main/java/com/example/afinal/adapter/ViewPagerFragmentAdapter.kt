//package com.example.afinal.adapter
//
//import androidx.fragment.app.Fragment
//import androidx.fragment.app.FragmentManager
//import androidx.lifecycle.Lifecycle
//import androidx.viewpager2.adapter.FragmentStateAdapter
//import com.example.afinal.Fragments.BookingFragment
//import com.example.afinal.Fragments.HospFragment
//
////class ViewPagerFragmentAdapter(activity: ArrayList<Fragment>) : FragmentStateAdapter(activity) {
////    override fun getItemCount(): Int {
////        return 2
////    }
////
////
////    override fun createFragment(position: Int): Fragment {
////        return when (position) {
////            0 -> HospFragment()
////            1 -> BookingFragment()
////            else -> HospFragment()
////
////        }
////    }
////}
//class ViewPagerFragmentAdapter(fa: FragmentManager, lifecycle: Lifecycle, private val docs : MutableList<Int>) :
//    FragmentStateAdapter(fa, lifecycle) {
//    override fun getItemCount(): Int {
//        return 2
//    }
//
//
//    override fun createFragment(position: Int): Fragment {
//        return when (position) {
//            0 -> HospFragment()
//            1 -> BookingFragment()
//            else -> HospFragment()
//
//        }
////    }
//}
//
