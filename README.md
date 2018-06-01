# Declaration
不允许修改layui版本及内容！！！
因layui默认ajax对数据的解析只支持一级，导致layui无法对源数据进行解析。后查看table.js源码，修改了源码使得支持多级数据，逻辑自己通过renderResponse(data)进行解析。
因此不可修改layui相关内容