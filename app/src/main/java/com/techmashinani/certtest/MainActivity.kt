package com.techmashinani.certtest

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.ShareCompat
import android.support.v4.view.GestureDetectorCompat
import android.util.Log
import android.view.*
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var mDetector: GestureDetectorCompat

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setup()
    }

    override fun onStart() {
        super.onStart()
        Log.e("onStart", "Called")
    }

    override fun onResume() {
        super.onResume()
        Log.e("onResume", "Called")
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item?.itemId) {
            R.id.action_logout -> {
                Toast.makeText(this, "Logout", Toast.LENGTH_LONG).show()
                return true
            }
            R.id.action_profile -> {
                Toast.makeText(this, "Profile", Toast.LENGTH_LONG).show()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menuInflater.inflate(R.menu.context, menu)
    }

    override fun onContextItemSelected(item: MenuItem?): Boolean {
        when(item?.itemId)  {
            R.id.action_edit -> {
                Toast.makeText(this, "Edit", Toast.LENGTH_LONG).show()
                return true
            }
            R.id.action_delete -> {
                Toast.makeText(this, "Delete", Toast.LENGTH_LONG).show()
                return true
            }
            R.id.action_share -> {
                Toast.makeText(this, "Share", Toast.LENGTH_LONG).show()
                return true
            }
        }
        return super.onContextItemSelected(item)
    }

    private fun setup() {
        setSupportActionBar(toolbar)

        registerForContextMenu(text_menu)

        but_send.setOnClickListener { shareTest() }

        mDetector = GestureDetectorCompat(this@MainActivity, MyGestureListener())
    }

    private fun testImplicitIntent() {
        val intent = Intent(Intent.ACTION_SEND)
        intent.putExtra(Intent.EXTRA_TEXT, "Hello")
        intent.type = "text/plain"

        if(intent.resolveActivity(packageManager) != null) {
            startActivity(Intent.createChooser(intent, getString(R.string.send_title)))
        } else {
            Toast.makeText(this@MainActivity, "No App to send text", Toast.LENGTH_LONG).show()
        }
    }

    private fun shareTest() {
        ShareCompat.IntentBuilder.from(this)
            .setChooserTitle(getString(R.string.send_title))
            .setType("text/plain")
            .setText("Hello Chooser")
            .startChooser()
    }

    private class MyGestureListener : GestureDetector.OnGestureListener {

        override fun onShowPress(e: MotionEvent?) {

        }

        override fun onSingleTapUp(e: MotionEvent?): Boolean {
            return true
        }

        override fun onDown(e: MotionEvent?): Boolean {
            return true
        }

        override fun onScroll(e1: MotionEvent?, e2: MotionEvent?, distanceX: Float, distanceY: Float): Boolean {
            return true
        }

        override fun onLongPress(e: MotionEvent?) {

        }

        override fun onFling(e1: MotionEvent?, e2: MotionEvent?, velocityX: Float, velocityY: Float): Boolean {
            // Toast.makeText(get, "", Toast.LENGTH_LONG).show()
            Log.e("Fling", "Done")
            return true
        }

    }
}
