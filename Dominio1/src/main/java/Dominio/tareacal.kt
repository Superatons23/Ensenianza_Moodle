package Dominio

import android.os.Parcel
import android.os.Parcelable

class tareacal() :Parcelable{
    constructor(parcel: Parcel) : this() {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<tareacal> {
        override fun createFromParcel(parcel: Parcel): tareacal {
            return tareacal(parcel)
        }

        override fun newArray(size: Int): Array<tareacal?> {
            return arrayOfNulls(size)
        }
    }
}