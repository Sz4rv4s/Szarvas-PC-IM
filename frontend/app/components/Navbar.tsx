import Link from "next/link";
import Image from "next/image";
import {auth, signOut, signIn} from "@/auth";

const Navbar = async () => {
  const session = await auth();

  return (
    <header className="px-5 py-3 bg-background shadow-sm font-OpenSans">
      <nav className="flex justify-between items-center">
        <Link href="/">
         <Image src="/icon.svg" alt="logo" width={50} height={20} />
        </Link>

        <div className="flex items-center gap-5">
          {session && session?.user ? (
            <>
              <form action={async () => {
                "use server";
                await signOut({redirectTo: "/"});
              }}>
                <button type="submit">Logout</button>
              </form>
              <Link href={`/user/${session?.user.id}`}>
                <span>{session.user.name}</span>
              </Link>
            </>
          ) : (
            <form action={async () => {
              "use server";
              await signIn("keycloak");
            }}>
              <button type="submit">Login</button>
            </form>
          )}
        </div>
      </nav>
    </header>
  )
}

export default Navbar;
