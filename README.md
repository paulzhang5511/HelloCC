# HelloCC
    
    用于测试Rust CC cates的用法


## 生成so

```
cargo ndk -t arm64-v8a -o ../app/src/main/jniLibs/  build
```

## 环境变量

* CARGO_CFG_UNIX—— 在类 Unix 平台上设置。
* CARGO_CFG_WINDOWS—— 在类 Windows 平台上设置。
* CARGO_CFG_TARGET_FAMILY=unix,wasm—— 目标系列。
* CARGO_CFG_TARGET_OS=macos—— 目标操作系统。
* CARGO_CFG_TARGET_ARCH=x86_64——CPU 目标架构。
* CARGO_CFG_TARGET_VENDOR=apple—— 目标供应商。
* CARGO_CFG_TARGET_ENV=gnu—— 目标环境 ABI。
* CARGO_CFG_TARGET_ABI=sim—— 目标 ABI。
* CARGO_CFG_TARGET_POINTER_WIDTH=64——CPU 指针宽度。
* CARGO_CFG_TARGET_ENDIAN=little——CPU 目标字节序为小端序。
* CARGO_CFG_TARGET_FEATURE=mmx,sse—— 启用的 CPU 目标特性列表。
