package vn.edu.vlsc.kiemtra_2500113793

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        // Ánh xạ View bằng findViewById
        val tvProfileEmail = findViewById<TextView>(R.id.tvProfileEmail)
        val btnLogout = findViewById<Button>(R.id.btnLogout)

        // Nhận chuỗi Email được truyền qua Intent
        val email = intent.getStringExtra("USER_EMAIL")
        tvProfileEmail.text = email ?: ""

        // Xử lý nút Đăng xuất: đóng Activity hiện tại
        btnLogout.setOnClickListener {
            finish()
        }
    }
}
