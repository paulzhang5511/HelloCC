fn main() {
    cc::Build::new()
        .file("../app/src/main/cpp/demo.c")
        .compile("foo");
}
