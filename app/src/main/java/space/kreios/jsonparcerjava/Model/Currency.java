package space.kreios.jsonparcerjava.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class Currency implements Parcelable{
    private String code;
    private Double value;

    public Currency(String code, Double value) {
            this.code = code;
            this.value = value;
            }

    protected Currency(Parcel in) {
        code = in.readString();
        value = in.readDouble();
    }

    public static final Parcelable.Creator<Currency> CREATOR = new Parcelable.Creator<Currency>() {
        @Override
        public Currency createFromParcel(Parcel in) {
            return new Currency(in);
        }

        @Override
        public Currency[] newArray(int size) {
            return new Currency[size];
        }
    };

    public String getCode() {return code;}
    public void setCode(String code) {this.code = code;}
    public Double getValue() {return value;}
    public void setValue(Double value) {this.value = value;}



    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(code);
        dest.writeDouble(value);
    }
}
