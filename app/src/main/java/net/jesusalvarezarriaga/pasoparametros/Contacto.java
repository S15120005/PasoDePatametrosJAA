package net.jesusalvarezarriaga.pasoparametros;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;

import java.io.Serializable;

public class Contacto implements Parcelable {

    public String usuario;
    public String email;
    public String twitter;
    public String telefono;
    public String fechaNacimiento;

    public Contacto(Parcel in) {
        usuario = in.readString();
        email = in.readString();
        twitter = in.readString();
        telefono = in.readString();
        fechaNacimiento = in.readString();
    }

    public static final Creator<Contacto> CREATOR = new Creator<Contacto>() {
        @Override
        public Contacto createFromParcel(Parcel in) {
            return new Contacto(in);
        }

        @Override
        public Contacto[] newArray(int size) {
            return new Contacto[size];
        }
    };

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) { this.fechaNacimiento = fechaNacimiento; }

    public Contacto(String usuario, String email, String twitter, String telefono, String fechaNacimiento) {
        this.usuario = usuario;
        this.email = email;
        this.twitter = twitter;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(usuario);
        parcel.writeString(email);
        parcel.writeString(twitter);
        parcel.writeString(telefono);
        parcel.writeString(fechaNacimiento);
    }
}
