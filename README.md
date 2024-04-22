# Bean的封装技巧
    1. 在vo类里面添加转换实体类方法，方便调用转换
        例如：可vo类可直接返回实体类，并设置默认值
            public WareIn convert() {
                WareIn wareIn = new WareIn();
                BeanUtils.copyProperties(this, wareIn);
                if (Objects.isNull(wareIn.getId())) {
                    wareIn.setWareInStatus(0);
                    wareIn.setWareInNo("RK20240419-01");
                    wareIn.setWareInTime(LocalDateTime.now());
                }
                return wareIn;
            }

    2. 实体类支持链式调用
        实体类上面加@Accessors(chain = true)注解
        例如：Student student = new Student().setName("张三").setAge(25);

        实体类上面加@Accessors(fluent = true)注解
        例如：Student student = new Student().age(20).name("张三");

        注意：调用父类的set方法后，返回的是父类(实体类)对象，要用父类对象接，实际对象还是vo类。(必须先调用子类方法，再调用父类方法)
        例如：Dog类继承了Animal类
            Animal animal = new Animal().setName("动物");
            Animal dog = new Dog().setMeta("肉").setName("狗");
            最后的setName是父类的方法，返回的是父类对象，所以要用Animal来接变量，但实际存储的还是Dog对象，可以强转Dog对象
            具体参照BeanCotroller类里面的main方法测试

    3. 创建mapper方法，mapper.xml里面的sql，在实现类impl里面用baseMapper来调用
        例如：Mapper里面创建了removeAll方法，xml也写了对应的sql
            在serviceImpl里面可直接用baseMapper.removeAll()来调用，不用再注入dao层
