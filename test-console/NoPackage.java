public class NoPackage {
    public static void main(final String... args) {
        System.out.println("getSimpleName() : " + NoPackage.class.getSimpleName());
        System.out.println("getCanonicalName() : " + NoPackage.class.getCanonicalName());
        System.out.println("getSimpleName() : " + String.class.getSimpleName());
        System.out.println("getCanonicalName() : " + String.class.getCanonicalName());
    }
}