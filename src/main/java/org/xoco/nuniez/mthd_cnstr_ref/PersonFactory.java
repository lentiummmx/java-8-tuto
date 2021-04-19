package org.xoco.nuniez.mthd_cnstr_ref;

public interface PersonFactory<P extends Person> {
    P create(String firstName, String lastName);
}
