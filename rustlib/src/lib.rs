#![cfg(target_os = "android")]
#![allow(non_snake_case)]
#![allow(non_upper_case_globals)]
#![allow(non_camel_case_types)]

use android_logger::{Config, FilterBuilder};
use jni::objects::{JClass, JString};
use jni::JNIEnv;
use log::LevelFilter;

fn init_log() {
    android_logger::init_once(
        Config::default()
            .with_max_level(LevelFilter::Trace)
            .with_tag("rustlib")
            .with_filter(FilterBuilder::new().parse("debug").build()),
    );
}

extern "C" {
    fn add(a1: i32, a2: i32) -> i32;
}

#[no_mangle]
pub extern "system" fn Java_com_example_hellocc_MainActivityKt_initLog<'local>(
    _env: JNIEnv<'local>,
    _class: JClass<'local>,
) {
    init_log();
}

#[no_mangle]
pub extern "system" fn Java_com_example_hellocc_MainActivityKt_hello<'local>(
    mut env: JNIEnv<'local>,
    _class: JClass<'local>,
    input: JString<'local>,
) -> JString<'local> {
    let result = unsafe {
        let a = add(1, 2);
        log::debug!("add result: {}", a);
        a
    };

    let s = format!("cpp: a1 + a2 = {}", result);

    env.new_string(s).unwrap()
}
