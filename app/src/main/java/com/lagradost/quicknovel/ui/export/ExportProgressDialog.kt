import android.app.ProgressDialog
import android.content.Context

class ExportProgressDialog(context: Context) {
    private val progressDialog: ProgressDialog = ProgressDialog(context)

    init {
        progressDialog.setCancelable(false)
        progressDialog.setMessage("Exporting...")
    }

    fun show() {
        progressDialog.show()
    }

    fun dismiss() {
        if (progressDialog.isShowing) {
            progressDialog.dismiss()
        }
    }
}