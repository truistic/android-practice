package cn.truistic.android.practice

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import cn.truistic.android.practice.common.menu.Menu
import cn.truistic.android.practice.common.menu.MenuAdapter
import cn.truistic.android.practice.common.menu.OnMenuItemClickListener
import cn.truistic.android.practice.recyclerview.RecyclerViewActivity

class MainActivity : AppCompatActivity(), OnMenuItemClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    private fun initViews() {
        val menus = mutableListOf<Menu>()
        menus.add(Menu(ID_RECYCLERVIEW, getString(R.string.recyclerview)))

        val menuRv: RecyclerView = findViewById(R.id.menu_rv)
        menuRv.layoutManager = LinearLayoutManager(this)
        menuRv.adapter = MenuAdapter(menus, this)
    }

    override fun onMenuClick(menu: Menu) {
        when (menu.id) {
            ID_RECYCLERVIEW -> startActivity(Intent(this, RecyclerViewActivity::class.java))
        }
    }

    companion object {
        private const val ID_RECYCLERVIEW = 0
    }
}
