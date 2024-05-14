/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package notepad;

import java.util.Scanner;
/**
 *
 * @author Anamaya Santi
 */
public class Notepad {

    /**
     * @param args the command line arguments
     */
        private final NoteSaya[] notes;

    public Notepad(int size) {
        notes = new NoteSaya[size];
    }

    public void displayMenu() {
        System.out.println("\nMenu:");
        System.out.println("1. Tambah catatan");
        System.out.println("2. Tampilkan catatan");
        System.out.println("3. Ubah catatan");
        System.out.println("4. Hapus catatan");
        System.out.println("5. Keluar");
    }

    public void addNote() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan catatan: ");
        String input = scanner.nextLine();
        for (int i = 0; i < notes.length; i++) {
            if (notes[i] == null) {
                notes[i] = new NoteSaya(input);
                System.out.println("Catatan berhasil ditambahkan.");
                return;
            }
        }
        System.out.println("Notepad penuh, catatan tidak dapat ditambahkan.");
    }

    public void displayNotes() {
        System.out.println("\nCatatan:");
        for (int i = 0; i < notes.length; i++) {
            if (notes[i] != null) {
                System.out.println(i + ": " + notes[i].getContent());
            }
        }
    }

    public void updateNote() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan indeks catatan yang ingin diubah: ");
        int index = scanner.nextInt();
        scanner.nextLine(); // consume newline
        if (index >= 0 && index < notes.length && notes[index] != null) {
            System.out.print("Masukkan catatan baru: ");
            String newContent = scanner.nextLine();
            notes[index].setContent(newContent);
            System.out.println("Catatan berhasil diubah.");
        } else {
            System.out.println("Indeks tidak valid atau catatan kosong.");
        }
    }

    public void deleteNote() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan indeks catatan yang ingin dihapus: ");
        int index = scanner.nextInt();
        scanner.nextLine(); // consume newline
        if (index >= 0 && index < notes.length && notes[index] != null) {
            notes[index] = null;
            System.out.println("Catatan berhasil dihapus.");
        } else {
            System.out.println("Indeks tidak valid atau catatan kosong.");
        }
    }

    public static void main(String[] args) {
            try (Scanner scanner = new Scanner(System.in)) {
                System.out.print("Masukkan ukuran notepad: ");
                int size = scanner.nextInt();
                scanner.nextLine(); // consume newline
                Notepad notepad = new Notepad(size);
                
                int choice;
                do {
                    notepad.displayMenu();
                    System.out.print("Pilih menu: ");
                    choice = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    switch (choice) {
                        case 1 -> notepad.addNote();
                        case 2 -> notepad.displayNotes();
                        case 3 -> notepad.updateNote();
                        case 4 -> notepad.deleteNote();
                        case 5 -> System.out.println("Keluar dari program.");
                        default -> System.out.println("Pilihan tidak valid.");
                    }
                } while (choice != 5);
            }
    }
}
   
