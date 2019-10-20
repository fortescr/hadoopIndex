# Exemplo de índice reverso de documentos com Hadoop

Aplicação simples para criar um job com índice reverso de documentos utilizando Apache Hadoop.

Para rodar o projeto no Windows foi necessário os arquivos disponiveis no link https://codeload.github.com/steveloughran/winutils/zip/master. Após descompactar em uma pasta apontar o caminho da propriedade hadoop.home.dir antes de rodar a aplicação, fixada na classe Application.

Também na classe Application. definir as pastas com os documentos (input) e as pastas de saída do índice (output).

Para rodar local foi necessário a classe NativeIO que deve ser mantida dentro do pacote org.apache.hadoop.io.nativeio. Alterar os métodos abaixo:

    private static native boolean access0(String path, int requestedAccess);
    private static native boolean access0(String var0, int var1);

    public static boolean access(String path, AccessRight desiredAccess)
        throws IOException {
      return access0(path, desiredAccess.accessRight());
    public static boolean access(String path, NativeIO.Windows.AccessRight desiredAccess) throws IOException {
        return true;
