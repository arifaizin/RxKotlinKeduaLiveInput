package id.hamasah.rxkotlinkedua

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.jakewharton.rxbinding2.widget.RxTextView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
//        Observable.create<String> { e: ObservableEmitter<String> ->
//
//            ed_inputan.addTextChangedListener(object : TextWatcher {
//                override fun afterTextChanged(p0: Editable?) {
//
//                }
//
//                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
//                }
//
//                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
//                    e.onNext(p0.toString())
//                }
//
//            })
//
//        }
//                .debounce(2000, TimeUnit.MILLISECONDS)
//                .subscribeOn(Schedulers.newThread())
//                .subscribeOn(AndroidSchedulers.mainThread())
//                .subscribe { t: String? -> tv_hasil.text = t }

                RxTextView.textChanges(ed_inputan)
                        .map { t: CharSequence -> t.toString() }
                .debounce(2000, TimeUnit.MILLISECONDS)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { t: String? -> tv_hasil.text = t }
    }
}

