
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.districtconnect.FormData
import com.example.districtconnect.FormViewHolder
import com.example.districtconnect.R

class FormsAdapter(private val forms: List<FormData>) : RecyclerView.Adapter<FormViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FormViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.form_cardview, parent, false)
        return FormViewHolder(view)
    }

    override fun onBindViewHolder(holder: FormViewHolder, position: Int) {
        val form = forms[position]
        holder.bindItems(form)
    }

    override fun getItemCount(): Int {
        return forms.size
    }
}
