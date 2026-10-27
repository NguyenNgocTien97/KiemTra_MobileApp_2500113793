package vn.edu.vlsc.kiemtra_2500113793

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Ánh xạ thành phần giao diện bằng findViewById
        val etEmail = findViewById<EditText>(R.id.etEmail)
        val etPassword = findViewById<EditText>(R.id.etPassword)
        val btnLogin = findViewById<Button>(R.id.btnLogin)
        val tvStatus = findViewById<TextView>(R.id.tvStatus)

        btnLogin.setOnClickListener {
            val email = etEmail.text.toString().trim()
            val password = etPassword.text.toString().trim()

            // Kiểm tra bỏ trống
            if (email.isEmpty()) {
                tvStatus.setTextColor(ContextCompat.getColor(this, android.R.color.holo_red_dark))
                tvStatus.text = "Lỗi: Email không được để trống!"
                return@setOnClickListener
            }
            if (password.isEmpty()) {
                tvStatus.setTextColor(ContextCompat.getColor(this, android.R.color.holo_red_dark))
                tvStatus.text = "Lỗi: Mật khẩu không được để trống!"
                return@setOnClickListener
            }

            // Kiểm tra mật khẩu >= 6 ký tự
            if (password.length < 6) {
                tvStatus.setTextColor(ContextCompat.getColor(this, android.R.color.holo_red_dark))
                tvStatus.text = "Lỗi: Mật khẩu phải có từ 6 ký tự trở lên!"
                return@setOnClickListener
            }

            // Dữ liệu hợp lệ -> Chuyển sang ProfileActivity và truyền dữ liệu email
            tvStatus.setTextColor(ContextCompat.getColor(this, android.R.color.holo_green_dark))
            tvStatus.text = "Đăng nhập hợp lệ"

            val intent = Intent(this, ProfileActivity::class.java)
            intent.putExtra("USER_EMAIL", email)
            startActivity(intent)
        }
    }
}
